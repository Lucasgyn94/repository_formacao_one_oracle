import getDados from "./getDados.js";

const params = new URLSearchParams(window.location.search);
const serieId = params.get('id');
const listaTemporadas = document.getElementById('temporadas-select');
const fichaSerie = document.getElementById('temporadas-episodios');
const fichaDescricao = document.getElementById('ficha-descricao');

// Função para carregar temporadas
function carregarTemporadas() {
    getDados(`/series/${serieId}/temporadas/todas`)
        .then(data => {
            const temporadasUnicas = [...new Set(data.map(temporada => temporada.temporada))];
            listaTemporadas.innerHTML = ''; // Limpa as opções existentes

            const optionDefault = document.createElement('option');
            optionDefault.value = '';
            optionDefault.textContent = 'Selecione a temporada';
            listaTemporadas.appendChild(optionDefault);

            temporadasUnicas.forEach(temporada => {
                const option = document.createElement('option');
                option.value = temporada;
                option.textContent = temporada;
                listaTemporadas.appendChild(option);
            });

            const optionTodas = document.createElement('option');
            optionTodas.value = 'todas';
            optionTodas.textContent = 'Todas as temporadas';
            listaTemporadas.appendChild(optionTodas);

            // Adiciona a opção "Top 5 episódios" ao dropdown
            const optionTop = document.createElement('option');
            optionTop.value = 'top';
            optionTop.textContent = 'Top 5 episódios';
            listaTemporadas.appendChild(optionTop);
        })
        .catch(error => {
            console.error('Erro ao obter temporadas:', error);
        });
}

// Função para carregar episódios de TODAS as temporadas
function carregarTodasAsTemporadas() {
    getDados(`/series/${serieId}/temporadas/todas`)
        .then(data => {
            console.log("Dados de todas as temporadas:", data); // Log para verificar os dados
            fichaSerie.innerHTML = '';

            // Agrupa os episódios por temporada
            const episodiosPorTemporada = {};
            data.forEach(episodio => {
                if (!episodiosPorTemporada[episodio.temporada]) {
                    episodiosPorTemporada[episodio.temporada] = [];
                }
                episodiosPorTemporada[episodio.temporada].push(episodio);
            });

            // Cria a lista de episódios para cada temporada
            for (const temporada in episodiosPorTemporada) {
                const ul = document.createElement('ul');
                ul.className = 'episodios-lista';

                const listaHTML = episodiosPorTemporada[temporada].map(episodio => `
                    <li>
                        ${episodio.numeroEpisodio} - ${episodio.titulo}
                    </li>
                `).join('');

                ul.innerHTML = listaHTML;

                const paragrafo = document.createElement('p');
                const linha = document.createElement('br');
                paragrafo.textContent = `Temporada ${temporada}`;
                fichaSerie.appendChild(paragrafo);
                fichaSerie.appendChild(linha);
                fichaSerie.appendChild(ul);
            }
        })
        .catch(error => {
            console.error('Erro ao obter episódios:', error);
        });
}

// Função para carregar episódios de uma temporada específica
function carregarEpisodios() {
    getDados(`/series/${serieId}/temporadas/${listaTemporadas.value}`)
        .then(data => {
            console.log("Dados da temporada:", data); // Log para verificar os dados
            fichaSerie.innerHTML = '';
            const ul = document.createElement('ul');
            ul.className = 'episodios-lista';

            const listaHTML = data.map(episodio => `
                <li>
                    ${episodio.numeroEpisodio} - ${episodio.titulo}
                </li>
            `).join('');

            ul.innerHTML = listaHTML;
            fichaSerie.appendChild(ul);
        })
        .catch(error => {
            console.error('Erro ao obter episódios:', error);
        });
}

// Função para carregar informações da série
function carregarInfoSerie() {
    getDados(`/series/${serieId}`)
        .then(data => {
            fichaDescricao.innerHTML = `
                <img src="${data.poster}" alt="${data.titulo}" />
                <div>
                    <h2>${data.titulo}</h2>
                    <div class="descricao-texto">
                        <p><b>Média de avaliações:</b> ${data.avaliacao}</p>
                        <p>${data.sinopse}</p>
                        <p><b>Estrelando:</b> ${data.atores}</p>
                    </div>
                </div>
            `;
        })
        .catch(error => {
            console.error('Erro ao obter informações da série:', error);
        });
}

// Função para carregar os top 5 episódios
function carregarTopEpisodios() {
    console.log("carregarTopEpisodios() chamada"); // Verificar se a função é chamada

    getDados(`/series/${serieId}/temporadas/top`)
        .then(data => {
            console.log("Dados dos top episódios:", data); // Verificar os dados da API

            fichaSerie.innerHTML = ''; // Limpa a área de exibição dos episódios

            const ul = document.createElement('ul');
            ul.className = 'episodios-lista';

            const listaHTML = data.map(episodio => `
                <li>
                    ${episodio.numeroEpisodio} - ${episodio.titulo}
                </li>
            `).join('');

            ul.innerHTML = listaHTML;
            fichaSerie.appendChild(ul);
        })
        .catch(error => {
            console.error('Erro ao obter top episódios:', error);
        });
}

// Adiciona ouvinte de evento para o elemento select
listaTemporadas.addEventListener('change', (event) => {
    console.log("Valor selecionado:", event.target.value); // Verificar o valor da opção selecionada

    if (event.target.value === 'top') {
        carregarTopEpisodios();
    } else if (event.target.value === 'todas') {
        carregarTodasAsTemporadas();
    } else {
        carregarEpisodios();
    }
});


// Carrega as informações da série e as temporadas quando a página carrega
carregarInfoSerie();
carregarTemporadas();

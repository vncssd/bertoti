const API_URL = 'http://localhost:8080/songs';

const modal = document.getElementById('id01');
const modalTitle = document.getElementById('modalTitle');
const inputID = document.getElementById('inputID');
const nomeMusica = document.getElementById('nomeMusica');
const artistasMusica = document.getElementById('artistasMusica');
const duracaoMusica = document.getElementById('duracaoMusica');
const formError = document.getElementById('formError');
const submitBtn = document.getElementById('submitBtn');
const songList = document.getElementById('song-list');

let editingId = null; // null = criando, senão = editando essa música

function formatarDuracao(segundos) {
    const m = Math.floor(segundos / 60);
    const s = segundos % 60;
    return String(m).padStart(2, '0') + ':' + String(s).padStart(2, '0');
}

// Converte "mm:ss" (ou só "ss") em segundos. Retorna null se inválido.
function parseDuracao(texto) {
    const match = /^(?:(\d+):)?(\d{1,2})$/.exec(texto.trim());
    if (!match) return null;
    const minutos = match[1] ? parseInt(match[1], 10) : 0;
    const segundos = parseInt(match[2], 10);
    if (segundos > 59) return null;
    return minutos * 60 + segundos;
}

function abrirModal(song) {
    formError.textContent = '';
    if (song) {
        editingId = song.id;
        modalTitle.textContent = 'Editar música';
        submitBtn.textContent = 'Salvar';
        inputID.value = song.id;
        nomeMusica.value = song.name;
        artistasMusica.value = song.artists.join(', ');
        duracaoMusica.value = formatarDuracao(song.duration);
    } else {
        editingId = null;
        modalTitle.textContent = 'Adicionar uma nova música';
        submitBtn.textContent = 'Adicionar';
        inputID.value = 'Gerado automaticamente';
        nomeMusica.value = '';
        artistasMusica.value = '';
        duracaoMusica.value = '';
    }
    modal.style.display = 'block';
}

function fecharModal() {
    modal.style.display = 'none';
}

function salvar() {
    const name = nomeMusica.value.trim();
    const artists = artistasMusica.value.split(',').map(a => a.trim()).filter(a => a);
    const duration = parseDuracao(duracaoMusica.value);

    if (!name) { formError.textContent = 'Informe o nome da música.'; return; }
    if (artists.length === 0) { formError.textContent = 'Informe ao menos um artista.'; return; }
    if (duration === null) { formError.textContent = 'Duração inválida. Use o formato mm:ss (ex: 03:45).'; return; }

    const body = { name, artists, duration };
    const request = editingId
        ? axios.put(API_URL + '/' + editingId, { id: editingId, ...body })
        : axios.post(API_URL, body);

    request
        .then(response => {
            console.log('Música salva', response.data);
            fecharModal();
            carregarMusicas();
        })
        .catch(error => {
            console.error('Erro ao salvar a música:', error);
            formError.textContent = 'Erro ao salvar a música.';
        });
}

function excluir(song) {
    axios.delete(API_URL + '/' + song.id)
        .then(response => {
            console.log('Deletado', response.data);
            carregarMusicas();
        })
        .catch(error => {
            console.error('Erro ao deletar', error);
        });
}

function criarCelula(texto) {
    const td = document.createElement('td');
    td.textContent = texto;
    return td;
}

function carregarMusicas() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            songList.innerHTML = '';
            data.forEach(song => {
                const tr = document.createElement('tr');
                tr.appendChild(criarCelula(song.id));
                tr.appendChild(criarCelula(song.name));
                tr.appendChild(criarCelula(song.artists.join(', ')));
                tr.appendChild(criarCelula(formatarDuracao(song.duration)));

                const acoes = document.createElement('td');
                const editBtn = document.createElement('button');
                editBtn.textContent = 'Editar';
                editBtn.className = 'btn btn-primary';
                editBtn.addEventListener('click', () => abrirModal(song));

                const deleteBtn = document.createElement('button');
                deleteBtn.textContent = 'Excluir';
                deleteBtn.className = 'btn btn-danger';
                deleteBtn.addEventListener('click', () => excluir(song));

                acoes.appendChild(editBtn);
                acoes.appendChild(deleteBtn);
                tr.appendChild(acoes);
                songList.appendChild(tr);
            });
        })
        .catch(error => console.error('Erro ao carregar músicas', error));
}

document.getElementById('openModalBtn').addEventListener('click', () => abrirModal(null));
document.getElementById('closeModalBtn').addEventListener('click', fecharModal);
submitBtn.addEventListener('click', salvar);
document.addEventListener('DOMContentLoaded', carregarMusicas);

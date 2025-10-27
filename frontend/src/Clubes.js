import { useEffect, useState } from 'react';

function Clubes() {
  const [clubes, setClubes] = useState([]); // estado para guardar os clubes

  useEffect(() => {
    async function buscarDados() {
      try {
        const resposta = await fetch('http://localhost:8080/clubes');
        const dados = await resposta.json();
        setClubes(dados);
      } catch (erro) {
        console.error('Erro ao buscar clubes:', erro);
      }
    }

    buscarDados();
  }, []);

  return (
    <div>
      <h1>Lista de Clubes</h1>
      <ul>
        {clubes.map((clube) => (
          <li key={clube.id}>
            <strong>{clube.nome}</strong> - Preço: {clube.preco}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Clubes;

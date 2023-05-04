import './App.css';
import { Routes, Route } from "react-router-dom";
import Cadastro from './components/Cadastro';
import Home from './components/Home'
import Curriculo from './components/curriculo';
import ListagemFiltro from './components/ListagemFiltro';
import Pesquisa from './components/pesquisa';
import Resultado from './components/resultado';




function App() {
	return (
		<div className="App">

            

			<Routes>
				<Route path="/" element={<Home />} />
				<Route path="/Cadastro" element={<Cadastro />} />
                <Route path = "/pesquisa" element = {<Pesquisa/>} />
                <Route path = "resultado" element = {<Resultado/>} />
                <Route path = "/curriculo" element = {<Curriculo/>} />
                <Route path = "/listagemfiltro" element = {<ListagemFiltro/>} />
				
			</Routes>

		</div>
	);
}

export default App;

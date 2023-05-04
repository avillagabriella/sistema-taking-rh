import { Link} from 'react-router-dom';
import { Nav, Navbar, NavbarBrand} from 'reactstrap';



export default function Home() {


	return (
		<>

       
            <div>
			    <Navbar className="barborda">

                    <img  className='logtk' src="/TK.png" alt="Logo da taking" /> 

                    
                        <Nav className='texto-um' navbar> 
				            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
                        </Nav>

                         <Nav className='texto-dois' navbar>
				            <NavbarBrand tag={Link} to="/Cadastro">Cadastro de Currículo</NavbarBrand>
                        </Nav>
                        
                        <Nav className='texto-tres' navbar>
                            <NavbarBrand tag={Link} to="/listagemfiltro">Busca de Currículo</NavbarBrand> 
                        </Nav>
			           
                        <Nav className='texto-quatro' navbar>
                            <NavbarBrand tag={Link} to="/pesquisa">Recursos Humanos</NavbarBrand> 
                        </Nav>
                       
			    </Navbar>

            </div>
			
		</>

	);
}

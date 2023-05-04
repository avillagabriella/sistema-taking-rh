// import Images from "./images";
import { Form, Label, Input, } from "reactstrap";
import BarraMenu from "./barramenu";
import Curriculo from "./curriculo";
import { useState } from "react";

export default function ListagemFiltro(){
const [showFields, setShowFields] = useState(false);
const [CPF, setCPF] = useState();

return(
        
    <>
       
    <BarraMenu/>
    
    
    <div className="body">
    <div>
    
        <h4>CONSULTA DE CURRÍCULOS</h4>
   
        <br/>

        <h5>Informe o CPF:</h5>

        
        <div className="div-form">
               
        <Form>    
       
            <div className="form-group row">
            <Label for="CPF" className="col-sm-2.5 col-form-label">CPF</Label>
            <div className="col-sm-11">
            <Input type="text" className="form-control" id="" placeholder="Digite o número do documento" onChange={(event) => setCPF(event.target.value)}/>
            </div>
            </div>
                
        <br />
            
            <input class="button-pesquisa" type="button" onClick={() =>{ 
                if (!CPF){ window.alert("O campo CPF precisa ser preenchido!")
            }else{
                setShowFields(true)
            }
            }} value="Pesquisar"></input>
            
        </Form>  
    
        </div>

    </div>         
    </div>
         <hr class= "largura-linha"/>
          <div className="div-form">
    {showFields && <> <Curriculo/>

    <div>    
        <Form>
        <input class="button-editar" type="button" value="Editar"></input> 
        </Form>
    </div>
    </>
}
</div>

    </>
    
)}
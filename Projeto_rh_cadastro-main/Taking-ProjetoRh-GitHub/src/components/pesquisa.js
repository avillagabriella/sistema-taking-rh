
import { Form } from "reactstrap";
import BarraMenu from "./barramenu";


function redirecionarPagina() {
    window.location.href = "resultado"
}

export default function Pesquisa (){

return(

    <>
    
    <BarraMenu/>

    <div className="body">

    <div>

        <h4>CONSULTA  DE CURRÍCULOS  NO BANCO DE DADOS</h4>

        <br/>

        <h5>Pesquisa básica:</h5>
         
       
        <div className="div-form">
        <Form>

            <div class="form-group row">
            <label for="Nome" class="col-sm-2 col-form-label">Nome</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite o primeiro nome"/>
            </div>
            </div>

            <br/>

            <div class="form-group row">
            <label for="Nome" class="col-sm-2 col-form-label">Sobrenome</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite o último nome"/>
            </div>
            </div>

            <br/>
        
            <div class="form-group row">
            <label for="Nome" class="col-sm-2 col-form-label">E-mail</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite o e-mail"/>
            </div>
            </div>

            <br/>
        
            <div class="form-group row">
            <label for="Nome" class="col-sm-2 col-form-label">Documento</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite o documento"/>
            </div>
            </div>

            <br/>

            <div class="form-group row">
            <div class="col-sm-20">
                <label for="Localização">Localização</label>
                    

                    <label class="pais-label" for="pais">País</label>
                    <select class="custom-select localizacao-opcao col-form-label" name="pais">
                    <option value="todos">Todos </option>
                    <option value="brasil">Brasil</option>
                    <option value="USA">USA </option>
                    <option value="Canada">Canada </option>
                    </select>
                    
                    <label class="estado-label" for="estado">UF</label>
                    <select class="custom-select localizacao-opcao col-form-label" name="estado">
                    <option value="todos">Todos</option>
                    <option value="SP">SP </option>
                    <option value="RJ">RJ </option>
                    <option value="MG">MG </option>
                    </select>
                
                    <label class="cidade-label" for="cidade">Cidade</label>
                    <select class="custom-select localizacao-opcao col-form-label" name="cidade">
                    <option value="todos">Todos</option>
                    <option value="Sao Paulo">São Paulo </option>
                    <option value="Rio de Janeiro">Rio de Janeiro </option>
                    <option value="Belo horizonte">Belo horizonte </option>
                    </select>
                </div>
             </div>
             <br/>
             <input class="button-pesquisa"  type="button" value="Pesquisar" onClick={redirecionarPagina}></input>
             
             
             
            
        </Form>

        </div>
          
        </div>

        </div>
        <hr class= "largura-linha"/>
      
    
      <div>
      <div className="body">
        <h5>Pesquisa avançada:</h5>

        <div className="div-form">
        <Form>

            <div class="form-group row">
            <label for="Nome" class="col-sm-2 col-form-label">Data de Nascimento</label>
            <div class="col-sm-3">
            <input type="date" class="form-control" id="" />
            </div>
            </div>

            <br/>

             
            <div class="form-group row">
            <div class="col-sm-11">
            <label  class="idioma-label" for="idioma">Idiomas </label>
                <select class="custom-select col-form-label" name="idioma" >
                    <option value="todos">Todos</option> 
                    <option value="ingles">Inglês</option>
                    <option value="espanhol">Espanhol</option>
                    <option value="frances">Português</option>
                      
                </select>
                
                <label class="nivel-label" for="nivel">Nível</label>
                <select class="custom-select col-form-label" name="nivel">
                    <option value="todos">Todos</option>   
                    <option value="basico">Básico</option>
                    <option value="intermediario">Intermediário</option>
                    <option value="avancado">Avançado</option>
                    <option value="fluente">Fluente</option>   
                </select>
            </div>
            </div>

            <br/>

            <div class="form-group row">
            <label for="interesses" class="col-sm-2 col-form-label">Interesses</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite as áreas de interesse"/>
            </div>
            </div>

            <br/>
        

            <div class="form-group row">
            <div class="col-sm-12">
            <label class="formacao-label col-form-label" for="formacao">Formação</label>
                <select class="custom-select col-form-label" name="idioma">
                    <option value="todos">Todos</option> 
                    <option value="mestrado">Doutorado</option> 
                    <option value="mestrado">Mestrado</option>  
                    <option value="pos-graduacao">Pós-Graduação</option>  
                    <option value="superior">Ensino Superior</option>                               
                    <option value="tecnico">Ensino Técnico</option>  
                    <option value="medio">Ensino Medio</option>  
                    
                </select>

                <label class="status-label" for="formacao">Status</label>
                <select class="custom-select col-form-label" name="nivel">
                    <option value="todos">Todos</option>
                    <option value="completo">Concluído</option> 
                    <option value="cursando">Em andamento</option>
                    <option value="incompleto">Paralisado</option> 
                </select>

                <br/>
                <label for="formacao" class="col-form-label"></label>
                <div class="formacao-col-9">
                    <input type="text" class="form-control" id="" placeholder="Digite a instituição e/ou o curso"/>
                </div>
            </div>
            </div>
            <br/>

            <div class="form-group row">
            <label for="experiencia" class="col-sm-2 col-form-label">Experiência</label>
            <div class="col-sm-9">
            <input type="text" class="form-control" id="" placeholder="Digite o cargo, empresa e/ou atividades realizadas"/>
            </div>
            </div>

            <br/>
        
            
            <div class="form-group row">
            <div class="col-sm-20">
                <label for="Localização">Localização</label>
                    

                    <label class="pais-label" for="pais">País</label>
                    <select class="custom-select localizacao-opcao col-form-label" name="pais">
                    <option value="todos">Todos </option>
                    <option value="brasil">Brasil</option>
                    <option value="USA">USA </option>
                    <option value="Canada">Canada </option>
                    </select>
                    
                    <label class="estado-label" for="estado">UF</label>
                    <select class="custom-select localizacao-opcao col-form-label" name="estado">
                    <option value="todos">Todos</option>
                    <option value="SP">SP </option>
                    <option value="RJ">RJ </option>
                    <option value="MG">MG </option>
                    </select>
                
                    <label class="cidade-label" for="cidade">Cidade</label>
                    <select class="custom-select localizacao-opcao col-form-label"  name="cidade">
                    <option value="todos">Todos</option>
                    <option value="São Paulo">São Paulo </option>
                    <option value="Rio de Janeiro">Rio de Janeiro </option>
                    <option value="Belo horizonte">Belo horizonte </option>
                    </select>
                </div>
                </div>
             
            <br/>
            <input class="button-pesquisa"  type="button" value="Pesquisar" onClick={redirecionarPagina}></input>
        </Form>
        
        </div>
     </div>
        
     </div>
    

    </>
);

}
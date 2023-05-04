import { Form, Label, Input, FormGroup, FormText, Row, Col, FormFeedback } from "reactstrap";
import { useState } from "react";
import Images from "./images";
import MenuBar from './MenuBar';

export default function Cadastro() {

	const [nomeInvalido, setNomeInvalido] = useState(false);
	const [sobrenomeInvalido, setSobrenomeInvalido] = useState(false);
	const [cpfInvalido, setCpfInvalido] = useState(false);
	const [emailInvalido, setEmailInvalido] = useState(false);

    const [showFields, setShowFields] = useState(false);


   {/* referente as msgs de erro do Submit
   
    const [showErrorAlert, setShowErrorAlert] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    */}


	const [candidato, setCandidato] = useState(
		{
			firstname: '',
			lastname: '',
			identificationDocument: '',
			email: '',
			birthdate: '',
			gender: '',
			phoneNumber: '',
			mobileNumber: '',
			disability: '',
			disability_type: '',
			country: '',
			addressZipCode: '',
			state: '',
			city: '',
			addressState: '',
			addressNumber: '',
			course: '',
			level: '',
			status: '',
			institution: '',
			formation: '',
			courseStart: '',
			courseEnd: '',
			startMonth: '',
			startYear: '',
			endMonth: '',
			endYear: '',
			languages: '',
			languages_skill: '',
			role: '',
			companyName: '',
			activitiesPerformed: '',
			area_interest: '',
			linkedinProfileUrl: ''

		});

	function handleChange(event) {

		if (event.target.name === 'firstname') {
			setNomeInvalido(false);
		} else if (event.target.name === 'lastname') {
			setSobrenomeInvalido(false);
		} else if (event.target.name === 'identificationDocument') {
			setCpfInvalido(false);
		} else if (event.target.name === 'email') {
			setEmailInvalido(false);
		}

		const target = event.target;
		const value = target.value;
		const name = target.name;

		var candidatoAtualizado = { ...candidato };

		candidatoAtualizado[name] = value;

		setCandidato(candidatoAtualizado)

	}

	function handleSubmit(event) {
		event.preventDefault(); 
		console.log(candidato);
	}


     {/* Integração com o back end através do Submit
     
     async function handleSubmit(){
        try{
        const response = await fetch('http://localhost:8080/candidato'),

     {
        method: 'POST',
         headers:{
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(candidato)
     }

    )
    
    if(response.ok){
        //exibe a msg de sucesso
        
    }else {

       const msgErro = await response.text();
       throw new Error(msgErro);
    }

   }  catch(e){
              
        //TODO: remover
         console.log('Error Message: ' + e.message);
  
         //TODO: exibir a mensagem de erro na tela para o usuário.
          setShowErrorAlert(true);
          setErrorMessage(e.message);
   }

  }

  function toggleAlert(){
    setShowErrorAlert(false);
    setErrorMessage('');
  }

    */}


	function handleInvalido(event) {
		if (event.target.name === 'firstname') {
			setNomeInvalido(true);
		} else if (event.target.name === 'lastname') {
			setSobrenomeInvalido(true);
		} else if (event.target.name === 'identificationDocument') {
			setCpfInvalido(true);
		} else if (event.target.name === 'email') {
			setEmailInvalido(true);
		}
	}

	return (
		<>

        <MenuBar />
    
			<Images />

            <div className="body">
            
				<div>

					<center>
						<h1>Cadastre seu currículo</h1>
						<p>Você pode preencher o formulário com os seus dados ou adicionar seu currículo através do último campo.</p>
					</center>

					<br />

                    <div className="div-form">

                {/* Corresponde a msg de erro

                    <Alert color="danger" isOpen={showErrorAlert} toggle={toggleAlert}>
                   {errorMessage}
                    </Alert>
                */}


						<h4>Dados Pessoais</h4>
						<br />


						<Form onSubmit={handleSubmit}>
							<Row>
								<Col>
									<div className="form-group row">
										<Label for="firstname" className="col-sm-2.5 col-form-label">Nome </Label>
										<div className="col-sm-12">
											<Input required invalid={nomeInvalido} type="text" className="form-control" name="firstname" id="firstname" placeholder="Digite o primeiro nome"
												onChange={handleChange} value={candidato.firstname} onInvalid={handleInvalido} />
											<FormFeedback invalid>Campo obrigatório</FormFeedback>
										</div>
									</div>
								</Col>

								<br />
								<Col>
									<div className="form-group row">
										<Label for="lastname" className="col-sm-2.5 col-form-label">Sobrenome </Label>
										<div className="col-sm-12">
											<Input required invalid={sobrenomeInvalido} type="text" className="form-control" name="lastname" id="lastname" placeholder="Digite o sobrenome"
												onChange={handleChange} value={candidato.lastname} onInvalid={handleInvalido} />
											<FormFeedback invalid>Campo obrigatório</FormFeedback>
										</div>
									</div>
								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<div className="form-group row">
										<Label for="identificationDocument" className="col-sm-2.5 col-form-label">Documento de Identificação</Label>
										<div className="col-sm-12">
											<Input required invalid={cpfInvalido} type="text" className="form-control" name="identificationDocument" id="identificationDocument" placeholder="Digite o CPF"
												onChange={handleChange} value={candidato.identificationDocument} onInvalid={handleInvalido} />
											<FormFeedback invalid>Campo obrigatório</FormFeedback>
										</div>
									</div>
								</Col>

								<br />

								<Col>
									<div className="form-group row">
										<Label for="email" className="col-sm-2.5 col-form-label">E-mail</Label>
										<div className="col-sm-12">
											<Input required invalid={emailInvalido} type="text" className="form-control" name="email" id="email" placeholder="Digite o e-mail"
												onChange={handleChange} value={candidato.email} onInvalid={handleInvalido} />
											<FormFeedback invalid>Campo obrigatório</FormFeedback>
										</div>
									</div>

								</Col>
							</Row>

							<br />

							<Row>
								<Col>

									<div className="form-group row">
										<Label for="birthdate" className="col-sm-2.5 col-form-label">Data de Nascimento</Label>
										<div className="col-sm-12">
											<Input type="date" className="form-control" name="birthdate" id="birthdate"
												onChange={handleChange} value={candidato.birthdate} />
										</div>
									</div>
								</Col>

								<br />

								<Col>
									<div className="form-group row">
										<FormGroup tag="fieldset">
											<Label for="gender" className="mb-3 col-form-label">Gênero</Label>
											<Row>
												<Col xs="auto">
													<FormGroup check>
														<Label check>
															<Input type="radio" name="gender" onChange={handleChange} value="Feminino" />{'Feminino'}
														</Label>
													</FormGroup>
												</Col>
												<Col>
													<FormGroup check>
														<Label check>
															<Input type="radio" name="gender" onChange={handleChange} value="Masculino" />{'Masculino'}
														</Label>
													</FormGroup>
												</Col>
											</Row>
										</FormGroup>
									</div>
								</Col>
							</Row>



							<br />
							<Row>
								<Col>
									<div className="form-group row">
										<Label for="phoneNumber" className="col-sm-2.5 col-form-label">Telefone</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="phoneNumber" id="phoneNumber" placeholder="Digite o telefone"
												onChange={handleChange} value={candidato.phoneNumber} />
										</div>
									</div>
								</Col>

								<br />

								<Col>
									<div className="form-group row">
										<Label for="mobileNumber" className="col-sm-2.5 col-form-label">Celular</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="mobileNumber" id="mobileNumber" placeholder="Digite o celular"
												onChange={handleChange} value={candidato.mobileNumber} />
										</div>
									</div>
								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<div className="form-group row">
										<FormGroup tag="fieldset">
											<Label for="disability" className="mb-3 col-form-label">Possui alguma deficiência?</Label>
											<Row>
												<Col xs="auto">
													<FormGroup check>
														<Label check>
															<Input type="radio" name="disability" onChange={handleChange} value="Sim" />{'Sim'}
														</Label>
													</FormGroup>
												</Col>
												<Col>
													<FormGroup check>
														<Label check>
															<Input type="radio" name="disability" onChange={handleChange} value="Não" />{'Não'}
														</Label>
													</FormGroup>
												</Col>
											</Row>
										</FormGroup>
									</div>
								</Col>

								<Col>
									<Label for="disability_type" className="col-sm-2.5 col-form-label">Qual deficiência possui?</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad deficiencia-opcao-cadastro col-form-label " name="disability_type" onChange={handleChange}>
											<option value="especifique a deficiencia"></option>
											<option value="deficiencia visual">Deficiência visual </option>
											<option value="deficiencia auditiva">Deficiência Auditiva</option>
											<option value="deficiencia motora">Deficiência Motora </option>
											<option value="outros">Outros </option>
										</select>
									</div>

								</Col>
							</Row>


							<br />
							<br />


							{/* ENDEREÇO*/}

							<h4>Endereço</h4>

							<br />



							<Row>
								<Col>

									<Label className="col-sm-2.5 col-form-label" for="country">País</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad localizacao-opcao-cadastro col-form-label" name="country" onChange={handleChange}>
											<option value="todos"></option>
											<option value="brasil">Brasil</option>
											<option value="USA">USA </option>
											<option value="Canada">Canada </option>
										</select>
									</div>


								</Col>
								<Col>

									<div className="form-group row">
										<Label for="addressZipCode" className="col-sm-2.5 col-form-label">CEP</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="addressZipCode" id="addressZipCode" placeholder="Digite o CEP"
												onChange={handleChange} value={candidato.addressZipCode} />
										</div>
									</div>


								</Col>
							</Row>

							<br />

							<Row>
								<Col>

									<Label className="col-sm-2.5 col-form-label" for="state">UF</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad localizacao-opcao-cadastro col-form-label" name="state" onChange={handleChange}>
											<option value="todos"></option>
											<option value="SP">SP </option>
											<option value="RJ">RJ </option>
											<option value="MG">MG </option>
										</select>
									</div>

								</Col>


								<br />


								<Col>

									<Label className="col-sm-2.5 col-form-label" for="city">Cidade</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad localizacao-opcao-cadastro col-form-label" name="city" onChange={handleChange}>
											<option value="todos"></option>
											<option value="Sao Paulo">São Paulo </option>
											<option value="Rio de Janeiro">Rio de Janeiro </option>
											<option value="Belo horizonte">Belo horizonte </option>
										</select>
									</div>

								</Col>
							</Row>

							<br />

							<Row>
								<Col>

									<div className="form-group row">
										<Label for="addressState" className="col-sm-2.5 col-form-label">Logradouro</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="addressState" id="addressState" placeholder=" Ex.: Rua Antonio da Costa"
												onChange={handleChange} value={candidato.addressState} />
										</div>
									</div>


								</Col>

								<Col>

									<div className="form-group row">
										<Label for="addressNumber" className="col-sm-2.5 col-form-label">Número</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="addressNumber" id="addressNumber" placeholder=" Ex: 94"
												onChange={handleChange} value={candidato.addressNumber} />
										</div>
									</div>


								</Col>

							</Row>

							<br />
							<br />

							{/* FORMAÇÃO ACADEMICA*/}


							<h4>Formação Acadêmica</h4>
							<br />


							<Row>
								<Col>

									<div className="form-group row">
										<div className="col-sm-12">
											<Label className="nivelescolaridade-label-cadastro" for="level">Nivel de Escolaridade</Label>
											<select className="custom-select-cad escolaridade-opcao-cadastro col-form-label" name="level" onChange={handleChange}>
												<option value="todos"></option>
												<option value="ensino medio">Ensino Médio</option>
												<option value="graduacao">Graduação</option>
												<option value="pos graduacao">Pós Graduação </option>
												<option value="mestrado">Mestrado </option>
												<option value="doutorado">Doutorado </option>
											</select>
										</div>
									</div>

								</Col>

								<br />
								<Col>

									<div className="form-group row">
										<div className="col-sm-12">
											<Label className="area-label" for="formation">Área de Formação</Label>
											<select className="custom-select-cad escolaridade-opcao-cadastro col-form-label" name="formation" onChange={handleChange}>
												<option value="todos"></option>
												<option value="tecnologia">Tecnologia</option>
												<option value="adm">Administração</option>
												<option value="rh">Recursos Humanos</option>
												<option value="gestao">Gestão</option>
											</select>
										</div>
									</div>

								</Col>
							</Row>
							<br />

							<Row>
								<Col>

									<Label for="course" className="col-sm-2.5 col-form-label">Curso</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad escolaridade-opcao-cadastro col-form-label" name="course" onChange={handleChange}>
											<option value="todos"></option>
											<option value="ads">Análise e Desenvolvimento de Sistemas</option>
											<option value="ciencia de dados">Ciência de Dados</option>
											<option value="ciencia da computacao">Ciência da Computação </option>
											<option value="sistemas de informacao">Sistemas de Informação</option>
										</select>
									</div>
								</Col>
								<Col>

									<Label className="instituicao-label" for="institution">Instituição de Ensino</Label>
									<select className="custom-select-cad escolaridade-opcao-cadastro col-form-label" name="institution" onChange={handleChange}>
										<option value="todos"></option>
										<option value="usp">Universidade de São Paulo</option>
										<option value="unicamp">Universidade Estadual de Campinas</option>
										<option value="ufrj">Universidade Estadual do Rio de Janeiro</option>
										<option value="uam">Universidade Anhembi Morumbi</option>
									</select>
								</Col>
							</Row>

							<br />

							<Row>
								<Col>


									<Label for="status" className="col-sm-2.5 col-form-label" >Status</Label>
									<div className="col-sm-12">
										<select className="custom-select-cad status-opcao-cadastro col-form-label" name="status" onChange={handleChange}>
											<option value="todos"></option>
											<option value="concluído">Concluído</option>
											<option value="andamento">Em andamento</option>
										</select>
									</div>


								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<div className="form-group row">
										<Label for="courseStart" className="col-sm-2.5 col-form-label">Data de Início</Label>
										<div className="col-sm-12">
											<Input type="date" className="form-control" name="courseStart" id="courseStart"
												onChange={handleChange} value={candidato.courseStart} />
										</div>
									</div>
								</Col>
								<Col>

									<div className="form-group row">
										<Label for="courseEnd" className="col-sm-2.5 col-form-label">Data de Conclusão</Label>
										<div className="col-sm-12">
											<Input type="date" className="form-control" name="courseEnd" id="courseEnd"
												onChange={handleChange} value={candidato.courseEnd} />
										</div>
									</div>


								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<input className="button-adicionar" type="button" value="Adicionar Formação"></input>
								</Col>


							</Row>

							<br />
							<br />

							{/* IDIOMAS*/}

							<h4>Idiomas</h4>
							<br />


							<Row>
								<Col>

									<div className="form-group row">
										<div className="col-sm-11">
											<div className="form-group row">
												<Label className="idiomas-label-cadastro" for="languages">Idioma</Label>
												<select className="custom-select-cad idiomas-opcao-cadastro col-form-label" name="languages" onChange={handleChange}>
													<option value=""></option>
													<option value="ingles">Inglês</option>
													<option value="espanhol">Espanhol </option>
													<option value="frances">Francês</option>
													<option value="outros">Outros</option>
												</select>
											</div>
										</div>
									</div>
								</Col>



								<br />

								<Col>

									<div className="form-group row">
										<div className="col-sm-12">
											<div className="form-group row"></div>
											<Label className="nivel-label-cadastro" for="languages_skill">Nível de Fluência</Label>
											<select className="custom-select-cad idiomas-opcao-cadastro col-form-label" name="languages_skill" onChange={handleChange}>
												<option value=""></option>
												<option value="basico">Básico</option>
												<option value="intermediario">Intermediário</option>
												<option value="avancado">Avançado</option>
											</select>
										</div>
									</div>

								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<input className="button-adicionar" type="button" value="Adicionar Idioma"></input>
								</Col>
							</Row>

							{/* EXPERIENCIA PROFISSIONAL*/}

							<br />
							<br />

							<h4>Experiência Profissional</h4>

							<br />


							<Row>
								<Col>
									<div className="form-group row">
										<div className="col-sm-20">
											<div className="form-group row">
												<Label for="role" className="col-sm-2.5 col-form-label">Cargo</Label>
												<div className="col-sm-12">
													<Input type="text" className="form-control" name="role" id="role" placeholder="Cargo" onChange={handleChange} />
												</div>
											</div>
										</div>
									</div>


								</Col>
								<Col>

									<div className="form-group row">
										<Label for="companyName" className="col-sm-2.5 col-form-label">Empresa</Label>
										<div className="col-sm-12">
											<Input type="text" className="form-control" name="companyName" id="companyName" placeholder="Nome da empresa" onChange={handleChange} />
										</div>
									</div>

								</Col>
							</Row>

							<br />


							<Row>
								<Col>
									<div className="form-group row">
										<Label for="jobStart" className="col-sm-2.5 col-form-label">Data de Início</Label>
										<div className="col-sm-12">
											<Input type="date" className="form-control" name="jobStart" id="jobStart" onChange={handleChange} />
										</div>
									</div>
								</Col>
								<Col>

									<div className="form-group row">
										<Label for="jobEnd" className="col-sm-2.5 col-form-label">Data de Conclusão</Label>
										<div className="col-sm-12">
											<Input type="date" className="form-control" name="jobEnd" id="jobEnd" onChange={handleChange} />
										</div>
									</div>


								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<div className="form-group row">
										<Label for="activitiesPerformed" sm={2.5}>Comente aqui sua experiência profissional:</Label>
										<Col sm={12}>
											<Input type="textarea" name="activitiesPerformed" id="activitiesPerformed" onChange={handleChange} />
										</Col>
									</div>

								</Col>
							</Row>

							<br />

							<Row>
								<Col>
									<input className="button-adicionar" type="button" value="Adicionar Experiência"></input>
								</Col>
							</Row>


							<br />
							<br />

							{/* INTERESSE*/}

							<h4>Área de interesse profissional</h4>

							<br />

							<Row>
								<Col>

									<div className="form-group row">
										<div className="col-sm-12">
											<div className="form-group row">
												<Label className="area_interest" for="area_interest">Qual a área de interesse:</Label>
												<select className="custom-select interesse-opcao col-form-label" name="area_interest" onChange={handleChange}>
													<option value=""></option>
													<option value="backend">Back-end</option>
													<option value="frontend">Front-end </option>
													<option value="gestao">Gestão</option>
													<option value="gestao">Full-Stack</option>
													<option value="gestao">Qualidade de Software</option>
													<option value="outros">Outros</option>
												</select>
											</div>
										</div>
									</div>

								</Col>
							</Row>

							<br />
							<br />

							{/* LINKEDIN*/}

							<h4>Linkedin</h4>

							<br />


							<Row>
								<Col>
									<div className="form-group row">
										<div className="col-sm-20">
											
												<Input type="text" name="linkedinProfileUrl" id="linkedinProfileUrl" placeholder="www.linkedin.com.br/"
													onChange={handleChange} value={candidato.linkedinProfileUrl} />
											</div>
										</div>
									
								</Col>
							</Row>

							<br />
							<br />

							{/* UPLOAD*/}

							<h4>Upload</h4>

							<br />

							<Row>
								<div className="form-group row">         
										<div className="form-group row">
											<Label for="Upload" className="col-sm-2 col-form-label"></Label>
											<Input type="file" name="upload" id="Upload" />
											<FormText color="muted">
												Aqui você pode fazer o Upload do seu currículo.
											</FormText>
										</div>
									</div>
							</Row>

							<br />
							<br />

							<Row>
								<Col>
									<input className="button-enviar" type="submit" value="Enviar"
									></input>
								</Col>
							</Row>

						</Form>
                        </div>	
				</div>
			
        </div>



		</>
	);

}
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../general/pageHeader.jsp" />
<div class="container" style="max-width: 750px">
	<br> <br> Bienvenido
	<s:property value="usuario.email" />


	<!-- Default form login -->
	<form name="guardarPregunta	" class="text-center border border-light p-5"
		action="guardarPregunta">

		<p class="h4 mb-4">
			<s:text name="Iniciar.Sesion" />
		</p>
		<!-- CATEGORIA -->

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01"><s:text
						name="categoria" /></label>
			</div>
			<s:select list="categorias" name="pregunta.categoria.idCategoria"
				listValue="nombre" listKey="idCategoria" 
				cssClass="browser-default custom-select"
				class="browser-default custom-select" />
		</div>

		<!-- PREGUNTA -->
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><s:text name="pregunta" /></span>
			</div>
			<textarea class="form-control" aria-label="With textarea"
				name="pregunta.nombre" maxlength="250"></textarea>
		</div>

		<!-- BOTON -->
		<button class="btn btn-info btn-block my-4" type="submit">
			<s:text name="Iniciar.Sesion" />
		</button>


		<jsp:include page="/pages/general/pageFooter.jsp" />
	</form>
</div>
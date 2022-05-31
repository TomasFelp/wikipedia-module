# Winchester 2 - wikipedia module

Instrucciones de uso:
  Utilizar el injector WikipediaInjector.kt para acceder al valor de wikipediaService el cual contiene el servicio externo; dicho servicio retorna objetos del tipo Description. El objeto mencionado anteriormente retorna un id y una descripción.
  Concatenar el id a la URL https://en.wikipedia.org/?curid= para acceder al artículo completo. 
  

 Para obtener la referencia:
  val wikipediaService = ayds.winchester2.wikipedia.WikipediaInjector.wikipediaService
  
 Para llamar al servicio:
  val descriptionWikipedia = wikipediaService.getArtistDescription(name)
  
  Edge Cases:
  Sin conexion a internet: wikipediaArticle es nulo 
  
  No hay resultado: wikipediaArticle es nulo 

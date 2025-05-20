import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.Random
import play.api.libs.json._
import io.circe.generic.auto._
import io.circe.parser._
import scala.io.Source


case class Event(event: String, year: Int, fun_fact: String)
case class War(name: String, start: Int, end: Int, fun_fact: String)
case class Figure(name: String, role: String, fun_fact: String)

case class Concept(term: String, definition: String, fun_fact: String)
case class Scientist(name: String, contribution: String, fun_fact: String)
case class Invention(name: String, use: String, fun_fact: String)

case class River(name: String, fact: String, fun_fact: String)
case class Mountain(name: String, height: String, fun_fact: String)
case class Country(name: String, continent: String, fun_fact: String)

case class History(dates: List[Event], wars: List[War], figures: List[Figure])
case class Science(concepts: List[Concept], scientists: List[Scientist], inventions: List[Invention])
case class Geography(rivers: List[River], mountains: List[Mountain], countries: List[Country])

case class Data(history: History, science: Science, geography: Geography)

def loadData(jsonPath: String): Option[Data] = {
 val json = Source.fromFile(jsonPath).mkString
 decode[Data](json).toOption  // loadData("data.json") match { case Some(data) => println("Data loaded successfully!")
 //case None => println("Failed to load or parse JSON.")
 
}


def respondTo(input: String, data: Data): String = {
 val lowerInput = input.toLowerCase

 // History - Events
 data.history.dates.find(e => lowerInput.contains(e.event.toLowerCase)) match {
  case Some(event) if lowerInput.contains("when") =>
   return s"The event '${event.event}' occurred in ${event.year}."
  case Some(event) if lowerInput.contains("fact") =>
   return s"Fun fact about '${event.event}': ${event.fun_fact}"
  case _ => 
 }

 // History - Wars
 data.history.wars.find(w => lowerInput.contains(w.name.toLowerCase)) match {
  case Some(war) if lowerInput.contains("when") || lowerInput.contains("date") =>
   return s"The '${war.name}' started in ${war.start} and ended in ${war.end}."
  case Some(war) if lowerInput.contains("fun") =>
   return s"Fun fact about '${war.name}': ${war.fun_fact}"
  case _ =>
 }

 // History - Figures
 data.history.figures.find(f => lowerInput.contains(f.name.toLowerCase)) match {
  case Some(fig) if lowerInput.contains("who") || lowerInput.contains("role") =>
   return s"${fig.name} was a ${fig.role}."
  case Some(fig) if lowerInput.contains("fun") =>
   return s"Fun fact about ${fig.name}: ${fig.fun_fact}"
  case _ =>
 }

 // Science - Concepts
 data.science.concepts.find(c => lowerInput.contains(c.term.toLowerCase)) match {
  case Some(concept) if lowerInput.contains("what") || lowerInput.contains("define") =>
   return s"${concept.term}: ${concept.definition}"
  case Some(concept) if lowerInput.contains("fun") =>
   return s"Fun fact about '${concept.term}': ${concept.fun_fact}"
  case _ =>
 }

 // Science - Scientists
 data.science.scientists.find(s => lowerInput.contains(s.name.toLowerCase)) match {
  case Some(scientist) if lowerInput.contains("contribution") =>
   return s"${scientist.name}'s contribution: ${scientist.contribution}"
  case Some(scientist) if lowerInput.contains("fun") =>
   return s"Fun fact about ${scientist.name}: ${scientist.fun_fact}"
  case _ =>
 }

 // Science - Inventions
 data.science.inventions.find(i => lowerInput.contains(i.name.toLowerCase)) match {
  case Some(invention) if lowerInput.contains("what") || lowerInput.contains("use") =>
   return s"The '${invention.name}' is used for: ${invention.use}"
  case Some(invention) if lowerInput.contains("fun") =>
   return s"Fun fact about '${invention.name}': ${invention.fun_fact}"
  case _ =>
 }

 // Geography - Rivers
 data.geography.rivers.find(r => lowerInput.contains(r.name.toLowerCase)) match {
  case Some(river) if lowerInput.contains("fact") || lowerInput.contains("info") =>
   return s"${river.name}: ${river.fact}"
  case Some(river) if lowerInput.contains("fun") =>
   return s"Fun fact about '${river.name}': ${river.fun_fact}"
  case _ =>
 }

 // Geography - Mountains
 data.geography.mountains.find(m => lowerInput.contains(m.name.toLowerCase)) match {
  case Some(mountain) if lowerInput.contains("how tall") || lowerInput.contains("height") =>
   return s"${mountain.name} has a height of ${mountain.height}."
  case Some(mountain) if lowerInput.contains("fun") =>
   return s"Fun fact about '${mountain.name}': ${mountain.fun_fact}"
  case _ =>
 }

 // Geography - Countries
 data.geography.countries.find(c => lowerInput.contains(c.name.toLowerCase)) match {
  case Some(country) if lowerInput.contains("continent") =>
   return s"${country.name} is in ${country.continent}."
  case Some(country) if lowerInput.contains("fun") =>
   return s"Fun fact about ${country.name}: ${country.fun_fact}"
  case _ => "Sorry, I couldn't find an answer to that."
 }


 
}



def greet():String={
 val message="Welcome to Two Truths & a Lie! I’ll show three statements—two are true, one’s a lie. Type ‘start’ to play!"

 message
}
def message():String={
 val message="Choose a category: science, history, or geography"
 message
}
def userInteractions(userinput: String): String = {
 userinput match {
  case input if input.contains("hi") || input.contains("hello") || input.contains("hey") =>
  greet()
  case _ =>
   "I didn't catch that."
 }
}

def parseInput(input: String): List[String] = {
 input.trim.toLowerCase.split("\\s+").toList
}

def botInteraction(userInput:List[String],)


def changeStatementToAnswer(lst: List[String], statements: List[String]): Int = {
 // Check for number-based input (1, 2, 3, etc.)

  if (lst.contains("2") || lst.contains("two") || lst.contains("second") || lst.contains("b")) return 2
 else if (lst.contains("3") || lst.contains("three") || lst.contains("third") || lst.contains("c")) return 3
 else if (lst.contains("1") || lst.contains("one") || lst.contains("first") || lst.contains("a")) return 1

 // Clean the user input to remove punctuation and trim extra spaces
 val text = lst.mkString(" ").toLowerCase.replaceAll("[^a-z0-9 ]", "").trim

 // Clean the statements by removing punctuation and converting to lowercase
 val cleanedStatements = statements.map(_.toLowerCase.replaceAll("[^a-z0-9 ]", "").trim)

 // Match user input with the statement by checking if key words or phrases appear
 val matchIndex = cleanedStatements.indexWhere(stmt => {
  // Look for the presence of each key word or phrase from the user input in the cleaned statement
  stmt.split(" ").exists(word => text.contains(word))
 })

 // If a match is found, return the corresponding index (1-based)
 if (matchIndex >= 0) return matchIndex + 1
 else return -1 // No match found
}

def evaluateAnswer(category: String, statements: List[String], correctLie: String, userChoice: Int): String = {
 category match {
  case "science" => evaluateScience(statements, correctLie, userChoice)
  case "geography" => evaluateGeography(statements, correctLie, userChoice)
  case "history" => evaluateHistory(statements, correctLie, userChoice)
  case _ => "Unknown category. Please make sure the category is correct."
 }
}

def evaluateScience(statements: List[String], correctLie: String, userChoice: Int): String = {
 if (userChoice < 1 || userChoice > 3)
  "Invalid choice. Please choose 1, 2, or 3."
 else if (statements(userChoice - 1) == correctLie) {
  val correctMessages = List(
   s"Great job! You spotted the lie. Your scientific knowledge is on point—keep it up!",
   s"Awesome! You caught the lie. You're really nailing this science quiz!",
   s"Well done! You correctly identified the lie. You're clearly a science pro!"
  )
  correctMessages(Random.nextInt(correctMessages.length))
 } else {
  val incorrectMessages = List(
   s"Oops, that's not quite right! The lie was: '$correctLie'. Science is all about discovery, and sometimes even the experts get it wrong. Keep exploring, and you'll get it next time!",
   s"Nice try! But the lie was: '$correctLie'. Science can be tricky, but you're on the right track—keep going!",
   s"Not quite! The lie was: '$correctLie'. Don't worry, science is full of surprises, and you're learning with every step!"
  )
  incorrectMessages(Random.nextInt(incorrectMessages.length))
 }
}
def evaluateHistory(statements: List[String], correctLie: String, userChoice: Int): String = {
 if (userChoice < 1 || userChoice > 3)
  "Invalid choice. Please choose 1, 2, or 3."
 else if (statements(userChoice - 1) == correctLie) {
  val correctMessages = List(
   "Correct! Zahy 7awas is proud nice work!",
   "Awesome! You spotted the lie. You're a history expert!",
   "Keep up the great work with history!"
  )
  correctMessages(Random.nextInt(correctMessages.length))
 } else {
  val incorrectMessages = List(
   s"Oops, that's not quite right! The lie was: '$correctLie'. History can be full of surprises, but don’t worry—every mistake is a step toward mastering the past.",
   s"Not quite! The lie was: '$correctLie'. But don't worry, history is full of fascinating facts, and you're getting closer every time!",
   s"Nice try! The lie was: '$correctLie'. Keep exploring history—you'll get it next time!"
  )
  incorrectMessages(Random.nextInt(incorrectMessages.length))
 }
}
def evaluateGeography(statements: List[String], correctLie: String, userChoice: Int): String = {
 if (userChoice < 1 || userChoice > 3)
  "Invalid choice. Please choose 1, 2, or 3."
 else if (statements(userChoice - 1) == correctLie) {
  val correctMessages = List(
   s"Correct! You nailed it! The lie was. Your geography knowledge is impressive!",
   s"Awesome! You caught the lie. You're a geography expert!",
   "Great job! You spotted the lie. Keep up the great work in geography!"
  )
  correctMessages(Random.nextInt(correctMessages.length))
 } else {
  val incorrectMessages = List(
   s"Oops, that's not quite right! The lie was: '$correctLie'. Geography can be tricky, but you're learning with every step!",
   s"Not quite! The lie was: '$correctLie'. Keep exploring the world—you're getting better at this!",
   s"Nice try! The lie was: '$correctLie'. Geography is full of fascinating facts, and you'll get it next time!"
  )
  incorrectMessages(Random.nextInt(incorrectMessages.length))
 }
}

def Quizcorrection(selectedAnswer: String,correctAnswer: String): Boolean = {
 selectedAnswer== correctAnswer
}
@tailrec
def runQuiz(questions: List[(List[String], String,String)],score:Int=0): Int = {
 if (questions.isEmpty) {
  println("\nQuiz finished. Good job!")
  println(finalscore(score))
  println(scoreAccuracy(score))
  return score
 }

 val (statements, lie,category) = questions.head

 println("Which one is the lie?")
 statements.zipWithIndex.foreach { case (s, i) =>
  println(s"${i + 1}. $s")
 }

 print("Your answer (1–3 or 'quit'): ")
 val input = scala.io.StdIn.readLine()

 if (input == "quit") {
  println(finalscore(score))
  println(scoreAccuracy(score))
  println(quitGame())
  return score
 }

 changeStatementToAnswer(parseInput(input),statements) match {
  case -1=>
   println("Invalid input. Please enter a number (1–3) or 'quit'.")
   runQuiz(questions) // repeat current question
  case n=>
   println(evaluateAnswer(category,statements,lie,n))
   if(Quizcorrection(statements(n - 1), lie)){
    runQuiz(questions.tail,score+1)
   }
   else{runQuiz(questions.tail,score)} // recurse with the remaining questions

 }
}

def finalscore(grade:Int): String={
 s"Your final score is $grade/10"

}
def scoreAccuracy(grade:Double): String={
 val per=(grade/10)*100
 s"your score accuracy is $per%"

}
def startGame(str:String):Option[Int]={
 str match{
  case "science"=>Some(runQuiz(scienceQuestions()))
  case "history"=>Some(runQuiz(historyQuestions()))
  case "geography"=>Some(runQuiz(GeographyQuestions()))
  case _=>None//try again
 }
}

def handleUserInput(input:String,category:String): Unit = {
 input match {
  case "start" => startGame(category)
  case "quit"=>Some(println(quitGame()))// function goodbye
  case _ => Some(wrongInput())// try again
 }
}
def quitGame():String={
 val message="Thanks for playing 'Two Truths & a Lie'! See you next time!"
 message
}
def wrongInput():String={
 val message="Invalid input."
 message
}
def correction(questions: List[String],selectedAnswer: String,correctAnswer: String): Boolean = {
 selectedAnswer== correctAnswer
}
@tailrec
def ExamStep(Questions: List[(List[String], String)],userAnswers: List[String],currentScore: Int = 0): Option[Int] = {
 (Questions, userAnswers) match {
  case (Nil, Nil) => Some(currentScore) // base case ye3ml return ll score 3ady lma y5ls el quiz
  case ((questions, lieStatement) :: qsTail, headAnswer :: asTail) =>
   if (correction(questions, headAnswer, lieStatement))//ys77
    ExamStep(qsTail, asTail, currentScore + 1)//yzwd score
   else
    ExamStep(qsTail, asTail, currentScore)//8lt, yseb el score zy mhowa
  case _ => None // y3ny d5l 7aga m4 mwgoda hntl3lo none
 }
}
def userAnswer(): List[String] = {
 @tailrec
 def helper(n: Int, acc: List[String]): List[String] = {
  if (n == 0) acc.reverse
  else {
   val input = readLine(s"Enter your answer for question ${11 - n}: ")
   helper(n - 1, input :: acc)
  }
 }

 helper(10, Nil)
}


def scienceQuestions():List[(List[String], String,String)]={
 val scienceQuestions = List(
  (List("Water boils at 100°C", "Humans have five hearts", "The Earth revolves around the Sun"), "Humans have five hearts","science"),
  (List("Photosynthesis needs sunlight", "Sound travels faster in air than in steel", "Plants produce oxygen"), "Sound travels faster in air than in steel","science"),
  (List("Electrons are negatively charged", "protons are positevly charged", "The brain weighs 10 kilograms"), "The brain weighs 10 kilograms","science"),
  (List("Neutrons have no charge", "The Sun is cold on the inside", "Viruses are smaller than bacteria"), "The Sun is cold on the inside","science"),
  (List("DNA carries genetic info", "The heart is a muscle", "Atoms are not made of protons"), "Atoms are not made of protons","science"),
  (List("The moon affects tides", "Gravity pulls things upward", "We breathe oxygen"), "Gravity pulls things upward","science"),
  (List("Humans have 206 bones", "Carbon dioxide is a noble gas", "The liver filters toxins"), "Carbon dioxide is a noble gas","science"),
  (List("Sound is a wave", "The eye sees with cones and rods", "The Earth is the center of the universe"), "The Earth is the center of the universe","science"),
  (List("Friction generates heat", "Plants have a nervous system", "Fire needs oxygen"), "Plants have a nervous system","science"),
  (List("The human body has red and white blood cells", "Ice is denser than water", "The skin is the largest organ"), "Ice is denser than water","science")
 )
 scienceQuestions
}

def historyQuestions(): List[(List[String],String,String)] = {
 val historyQuestions = List(
  (List("World War II ended in 1945", "The Roman Empire was based in Germany", "The pyramids are in Egypt"), "The Roman Empire was based in Germany","history"),
  (List("Julius Caesar was assassinated", "The Declaration of Independence was in 1776", "Napoleon discovered gravity"), "Napoleon discovered gravity","history"),
  (List("The Cold War involved the US and USSR", "The Great Fire of London was in 1666", "Mona Lisa was painted by Van Gogh"), "Mona Lisa was painted by Van Gogh","history"),
  (List("World War I started in 1914", "Abraham Lincoln was a US president", "The moon landing was in the 1800s"), "The moon landing was in the 1800s","history"),
  (List("The Berlin Wall fell in 1989", "The Titanic sank in 1912", "Genghis Khan ruled France"), "Genghis Khan ruled France","history"),
  (List("Cleopatra was Egyptian", "The internet was invented in the 1960s", "The US Civil War was in the 2000s"), "The US Civil War was in the 2000s","history"),
  (List("Hitler was German", "The Great Wall is in China", "Leonardo da Vinci was a musician"), "Leonardo da Vinci was a musician","history"),
  (List("Ancient Greece influenced democracy", "The French Revolution was in the 1600s", "The Wright brothers invented the airplane"), "The French Revolution was in the 1600s","history"),
  (List("Martin Luther King Jr. gave the 'I Have a Dream' speech", "World War II started in 1939", "The Renaissance happened after the Industrial Revolution"), "The Renaissance happened after the Industrial Revolution","history"),
  (List("The first Olympics were in Greece", "Napoleon was short", "The Black Death was a type of dance"), "The Black Death was a type of dance","history")
 )
 historyQuestions
}

def GeographyQuestions(): List[(List[String], String,String)] = {
 val GeographyQuestions = List(
  (List("Nile is the longest river", "Mount Everest is the highest mountain", "Sahara is in South America"), "Sahara is in South America","geography"),
  (List("Africa is a continent", "Japan is in Europe", "Australia is both a country and a continent"), "Japan is in Europe","geography"),
  (List("The Amazon is in South America", "Greenland is the smallest continent", "Asia is the largest continent"), "Greenland is the smallest continent","geography"),
  (List("Russia spans two continents", "Antarctica has no permanent population", "The equator passes through Canada"), "The equator passes through Canada","geography"),
  (List("The capital of France is Paris", "The Atlantic is the largest ocean", "Brazil is in South America"), "The Atlantic is the largest ocean","geography"),
  (List("There are 7 continents", "The Pacific Ocean is the deepest", "Switzerland is on the coast"), "Switzerland is on the coast","geography"),
  (List("The Dead Sea is below sea level", "The UK is part of Scandinavia", "India is in Asia"), "The UK is part of Scandinavia","geography"),
  (List("Egypt is in Africa", "China borders more countries than any other", "Iceland is a tropical country"), "Iceland is a tropical country","geography"),
  (List("Deserts can be cold", "The Great Wall of China is visible from space", "Lake Baikal is in Russia"), "The Great Wall of China is visible from space","geography"),
  (List("The Andes are in South America", "There are 195 countries", "Alaska is south of Hawaii"), "Alaska is south of Hawaii","geography")
 )
 GeographyQuestions
}




@main def run(): Unit = {
 println(greet())
 var userInput = readLine().trim.toLowerCase
 if(userInput=="quit"){
  quitGame()
  return
 }
 while(userInput != "quit" && userInput != "start") {
  println("Invalid Input,Try Again")
  println(greet())
  userInput = readLine().trim.toLowerCase

 }
 println(message())
 val category=readLine().trim.toLowerCase
 if(category=="quit"){
  quitGame()
  return
 }
 handleUserInput(userInput,category)

}












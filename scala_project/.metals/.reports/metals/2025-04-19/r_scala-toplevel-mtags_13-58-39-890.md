error id: file:///C:/Users/messi/OneDrive/scala%20project/src/main/scala/Main.scala:[316..319) in Input.VirtualFile("file:///C:/Users/messi/OneDrive/scala%20project/src/main/scala/Main.scala", "

def greet():String={
  val message="Welcome to Two Truths & a Lie! I’ll show three statements—two are true, one’s a lie. Type ‘start’ to play!"
  message
}
def parseInput(input: String): List[String] = {
  val trimmed = input.trim.toLowerCase
  if (trimmed.isEmpty) List() else List(trimmed)
}
def 


def scienceQuestions():List[(List[String], String)]={
  val scienceQuestions = List(
  (List("Water boils at 100°C", "Humans have five hearts", "The Earth revolves around the Sun"), "Humans have five hearts"),
  (List("Photosynthesis needs sunlight", "Sound travels faster in air than in steel", "Plants produce oxygen"), "Sound travels faster in air than in steel"),
  (List("Electrons are negatively charged", "The brain runs on electricity", "The brain weighs 10 kilograms"), "The brain weighs 10 kilograms"),
  (List("Neutrons have no charge", "The Sun is cold on the inside", "Viruses are smaller than bacteria"), "The Sun is cold on the inside"),
  (List("DNA carries genetic info", "The heart is a muscle", "Atoms are not made of protons"), "Atoms are not made of protons"),
  (List("The moon affects tides", "Gravity pulls things upward", "We breathe oxygen"), "Gravity pulls things upward"),
  (List("Humans have 206 bones", "Carbon dioxide is a noble gas", "The liver filters toxins"), "Carbon dioxide is a noble gas"),
  (List("Sound is a wave", "The eye sees with cones and rods", "The Earth is the center of the universe"), "The Earth is the center of the universe"),
  (List("Friction generates heat", "Plants have a nervous system", "Fire needs oxygen"), "Plants have a nervous system"),
  (List("The human body has red and white blood cells", "Ice is denser than water", "The skin is the largest organ"), "Ice is denser than water")
)
  scienceQuestions
}

def historyQuestions(): List[(List[String], String)] = {
  val historyQuestions = List(
    (List("World War II ended in 1945", "The Roman Empire was based in Germany", "The pyramids are in Egypt"), "The Roman Empire was based in Germany"),
    (List("Julius Caesar was assassinated", "The Declaration of Independence was in 1776", "Napoleon discovered gravity"), "Napoleon discovered gravity"),
    (List("The Cold War involved the US and USSR", "The Great Fire of London was in 1666", "Mona Lisa was painted by Van Gogh"), "Mona Lisa was painted by Van Gogh"),
    (List("World War I started in 1914", "Abraham Lincoln was a US president", "The moon landing was in the 1800s"), "The moon landing was in the 1800s"),
    (List("The Berlin Wall fell in 1989", "The Titanic sank in 1912", "Genghis Khan ruled France"), "Genghis Khan ruled France"),
    (List("Cleopatra was Egyptian", "The internet was invented in the 1960s", "The US Civil War was in the 2000s"), "The US Civil War was in the 2000s"),
    (List("Hitler was German", "The Great Wall is in China", "Leonardo da Vinci was a musician"), "Leonardo da Vinci was a musician"),
    (List("Ancient Greece influenced democracy", "The French Revolution was in the 1600s", "The Wright brothers invented the airplane"), "The French Revolution was in the 1600s"),
    (List("Martin Luther King Jr. gave the 'I Have a Dream' speech", "World War II started in 1939", "The Renaissance happened after the Industrial Revolution"), "The Renaissance happened after the Industrial Revolution"),
    (List("The first Olympics were in Greece", "Napoleon was short", "The Black Death was a type of dance"), "The Black Death was a type of dance")
  )
  historyQuestions
}

def GeographyQuestions(): List[(List[String], String)] = {
  val GeographyQuestions = List(
    (List("Nile is the longest river", "Mount Everest is the highest mountain", "Sahara is in South America"), "Sahara is in South America"),
    (List("Africa is a continent", "Japan is in Europe", "Australia is both a country and a continent"), "Japan is in Europe"),
    (List("The Amazon is in South America", "Greenland is the smallest continent", "Asia is the largest continent"), "Greenland is the smallest continent"),
    (List("Russia spans two continents", "Antarctica has no permanent population", "The equator passes through Canada"), "The equator passes through Canada"),
    (List("The capital of France is Paris", "The Atlantic is the largest ocean", "Brazil is in South America"), "The Atlantic is the largest ocean"),
    (List("There are 7 continents", "The Pacific Ocean is the deepest", "Switzerland is on the coast"), "Switzerland is on the coast"),
    (List("The Dead Sea is below sea level", "The UK is part of Scandinavia", "India is in Asia"), "The UK is part of Scandinavia"),
    (List("Egypt is in Africa", "China borders more countries than any other", "Iceland is a tropical country"), "Iceland is a tropical country"),
    (List("Deserts can be cold", "The Great Wall of China is visible from space", "Lake Baikal is in Russia"), "The Great Wall of China is visible from space"),
    (List("The Andes are in South America", "There are 195 countries", "Alaska is south of Hawaii"), "Alaska is south of Hawaii")
  )
  GeographyQuestions
}



@main def run(): Unit = {
   val x=greet()
   println(x)
   println(GeographyQuestions()(0)._1)

}











")
file:///C:/Users/messi/OneDrive/scala%20project/src/main/scala/Main.scala:14: error: expected identifier; obtained def
def scienceQuestions():List[(List[String], String)]={
^
#### Short summary: 

expected identifier; obtained def
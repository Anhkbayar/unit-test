# Unit test

## B232270029, З.Анхбаяр

### Туршилтын тохиргоо

* **Java version:** openjdk 25.0.4 2026-07-21
  OpenJDK Runtime Environment (build 25.0.4+7-1-26.04-Ubuntu)
  OpenJDK 64-Bit Server VM (build 25.0.4+7-1-26.04-Ubuntu, mixed mode, sharing)
* **Maven version:** Apache Maven 3.9.12
  Maven home: /usr/share/maven
  Java version: 25.0.4, vendor: Ubuntu, runtime: /usr/lib/jvm/java-25-openjdk-amd64
  Default locale: en_US, platform encoding: UTF-8
  OS name: "linux", version: "7.0.0-31-generic", arch: "amd64", family: "unix"

### Тестийн мэдээлэл

* **Тестийн методын тоо:** 8
* **Parameterized test:** 2

  * `letterGrade`-ийн хязгаарын утгууд
  * `totalScore`-ийн тооцоолол
* **Тестийн үр дүн:** `results/mvn-test.txt`
* **Tests run:** 40
* **Failures:** 0
* **Errors:** 0
* **Skipped:** 0
* **Build:** `BUILD SUCCESS`

### Хийсэн ажлын тайлбар

GradeCalculator классын `letterGrade` болон `totalScore` методуудад нэгжийн тестүүд бичсэн.
Тестүүдийг Arrange–Act–Assert (AAA) бүтэцтэйгээр зохион байгуулж, тест бүрт ойлгомжтой `@DisplayName` ашигласан.
`letterGrade` методын хувьд 100, 95, 90, 89.99, 85, 80, 79, 75, 70, 69, 65, 60, 59.99, 50, 30 зэрэг ердийн болон хязгаарын утгуудыг шалгасан.
Мөн -15.0 болон 102.52 зэрэг буруу оноонд `IllegalArgumentException` үүсэж байгаа эсэхийг `assertThrows` ашиглан шалгасан.
`totalScore` методын хувьд зөв нийлбэр тооцож байгаа эсэхээс гадна сөрөг утга болон зөвшөөрөгдөх дээд хязгаараас хэтэрсэн утгыг exception үүсгэж байгаа эсэхийг шалгасан.
Ижил логиктой олон тохиолдлыг шалгахын тулд `@ParameterizedTest` ашиглан `letterGrade` болон `totalScore`-д тус бүр нэг parameterized тест бичсэн.

### Mutation testing

`letterGrade` методын `case 10,9 -> A` тохиолдлыг `case 10 -> A` болгон өөрчилж mutation test хийсэн.
Энэ өөрчлөлтийн үед 90 оноо `A` байх ёстойг шалгасан boundary test унасан бөгөөд `results/mvn-test-mutant.txt` файлд `Failures >= 1` болон `BUILD FAILURE` гарсан.
Унасан тест нь **90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)** гэсэн тест байсан.
Шалгалт унах нөхцөлийг `GradeWrongCalculator` болон `GradeFailTest` файлд баримтжуулах үүднээс үлдээсэн.

### Хамгийн сонирхолтой тест

Хамгийн сонирхолтой нь 90 онооны boundary test байсан.
Учир нь `case 10, 9` нөхцөлийг `case 10` болгон багахан өөрчлөхөд энэ тест шууд унаж, хязгаарын нөхцөлийг тестлэхийн ач холбогдлыг харуулсан.
89.99 болон 90 гэсэн хоёр ойролцоо утгыг тусад нь шалгаснаар `A` болон `B` үнэлгээний зааг зөв хэрэгжсэн эсэхийг шалгах боломжтой болсон.

### Үр дүнгийн файл

* `results/mvn-test.txt` — бүх тест амжилттай ажилласан эцсийн үр дүн
* `results/mvn-test-mutant.txt` — зориуд mutation хийсний дараах тестийн үр дүн


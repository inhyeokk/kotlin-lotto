# 문자열 덧셈 계산기

## 기능 요구 사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있음
* 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용
  * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 

## 프로그래밍 요구 사한 (제한
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현
* 함수의 길이가 10라인을 넘어가지 않도록 제한

## 기능 구현 목록 정리
* [X] Calculator::add : List<Int> 타입을 입력받으면 전부 더해서 결과값을 리턴해주는 싱글톤 객체 
* [X] ExpressionParser : input 을 받아서 List<Int> 로 숫자들을 파싱해준다
  * `String` 타입의 Input 을 받아서 regex 를 이용하여 List<Int> 로 분리해줄 수 있음
  * `() -> Unit` 타입의 validFunction 을 입력받아서 validation 을 진행 -> 일단 private 내장 함수로 구현
* [X] CustomExpressionParser : input 을 받아서 List<Int> 로 숫자를 파싱해준다
  * `String` 타입의 Input 을 받아서 regex 를 이용하여 List<Int> 로 분리해줄 수 있음
  * `//[.]\n` 에서 기준선을 잡아서 이 후 문자열을 파싱하여 List<Int> 로 분리해줄 수 있음
  * `() -> Unit` 타입의 validFunction 을 입력받아서 validation 을 진행
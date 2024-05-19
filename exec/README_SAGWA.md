# 🍎 SAGWA 🍎
![image](/uploads/8fb9227ecaa46690abc36ccb0bc85666/image.png)

# ✨ 목차
- 🛫 [프로젝트 소개](#-프로젝트-소개)
- 🌈 [기획 배경](#-기획-배경)
- 📝 [와이어프레임](#-와이어프레임)
- 💡 [주요 기능](#-주요-기능)
    - 1️⃣ 메인
    - 2️⃣ 일기 작성, 조회, 삭제
    - 3️⃣ 통화 기록 조회 대상 추가 및 삭제, 기록 조회, 통계 조회
- 🛠 [기술 스택](#-기술-스택)
- 🚧 [시스템 아키텍쳐](#-시스템-아키텍쳐)
- 📂 [프로젝트 구조](#-프로젝트-구조)
- 💻 [역할](#-역할)

<br>

# 🛫 프로젝트 소개
| 프로젝트 기간 | 2024.05.08 ~ 2024.05.16 (약 1주) |
| --- | --- |

<br>

# 🌈 기획 배경
### ***“사랑하는 사람들과, 소중한 기록”*** <br>
우리의 일상에서 *가장 소중한 순간*은 언제일까요?<br>
저희는 이 질문에 대한 답으로 사랑하는 사람들과 함께 하는 시간이라고 생각했습니다.<br>
"사과"는 바쁜 일상 속에서도 우리가 소중한 이들과 얼마나 자주 연락하는지 시각적으로 보여주고, 그 순간의 감정과 생각을 일기로 기록하고자 만든 어플입니다. 사랑하는 사람과의 대화가 어떻게 우리 삶을 풍요롭게 하는지, 그리고 그 순간들을 어떻게 소중히 간직했는지 확인할 수 있습니다.<br>

"사과"와 함께, 일상의 소중한 시간들을 되새겨 보세요!

<br>

# 📝 와이어프레임
![sagwa_wireframe](/uploads/d717e755b4a7ef66f96b576a16bb49e7/sagwa_wireframe.png)

<br>

# 💡 주요 기능
## 1️⃣ 메인
![메인](/uploads/5d92f21f59a9d9c75c37c9825cd4a361/메인.gif)

- 로딩화면을 지나 메인 페이지인 캘린더로 이동합니다.
- 일기가 작성된 날짜에는 하단에 일기의 내용을 간략하게 볼 수 있습니다.
- 상단 헤더의 today를 누르면 다시 오늘 날짜로 돌아올 수 있습니다.

<br>

## 2️⃣ 일기 작성, 조회, 삭제
![일기](/uploads/25d4641c85fe6800e74915d408f905cc/일기.gif)

### **1. 작성**
- 하단바의 오늘의 일기를 눌러 작성 페이지로 이동합니다.
- 제목, 사진, 내용을 작성하고 등록하고 오늘 날짜의 일기가 추가된 것을 확인할 수 있습니다.
- *만약 오늘이 아닌 날짜의 일기를 등록하고 싶다면 메인 페이지의 캘린더 하단에 있는 '작성하러 가기' 버튼을 눌러 작성할 수 있습니다.*


### **2. 조회**
- 메인 페이지에서 일기를 눌러 상세 페이지로 이동합니다.
- 작성한 제목, 사진, 내용을 비롯해 오늘의 날씨를 볼 수 있습니다.


### **3. 삭제**
- 상세 페이지의 하단 삭제 버튼을 눌러 작성한 일기를 삭제할 수 있습니다.

<br>

## 3️⃣ 통화 기록 조회 대상 추가 및 삭제, 기록 조회, 통계 조회
![통화](/uploads/d92d805e4e2d51acbb09bad019478cbc/통화.gif)

### **1. 통화 기록 조회 대상 추가 및 삭제**
- 탭을 이동하여 통화 기록 조회 대상을 추가하는 페이지로 이동합니다.
- 대상의 번호와 이름을 입력하고 새로 추가된 대상을 확인할 수 있습니다.
- *우측 x 버튼을 눌러 통화 기록 조회 대상에서 삭제할 수 있습니다.*

### **2. 통화 통계 조회**
- 대상과 한 달에 몇 번 통화했는지 그래프로 볼 수 있습니다.

### **3. 통화 기록 조회**
- 탭을 이동하여 등록한 대상들과의 통화 기록을 조회할 수 있습니다.
- *상단 헤더에서 월(月)을 이동하여 월별 통화 기록이 조회 가능합니다.*

<br>

# 🛠 기술 스택
![infra](/uploads/45666cdf70c6dd7a8f107b6a4790809b/infra.png)

<br>

# 🚧 시스템 아키텍쳐

<br>

# 📂 프로젝트 구조
### 1️⃣ Android Studio(Mobile)
```
📦front
├─ 📂.gradle
├─ 📂.idea
├─ 📂app
│   ├─ 📂build
│   └─ 📂src
│       ├─ 📂androidTest
│       └─ 📂main
│           ├─ 📂java.com.ssafy.lsagwa
│           │   ├─ 📂activity
│           │   │   ├─ 📜CalendarActivity.java
│           │   │   ├─ 📜CallListActivity.java
│           │   │   ├─ 📜DiaryDetailActivity.java
│           │   │   ├─ 📜SignInActivity.java
│           │   │   ├─ 📜SignUpActivity.java
│           │   │   ├─ 📜SplashActivity.java
│           │   │   └─ 📜WriteActivity.java
│           │   ├─ 📂api
│           │   │   ├─ 📂Diary
│           │   │   ├─ 📂Member
│           │   │   └─ 📂PhoneBook
│           │   └─ 📂util
│           │       └─ 📜TrustOkHttpClientUtil.java
│           ├─ 📂res
│           │   ├─ 📂drawable
│           │   ├─ 📂font
│           │   ├─ 📂font-v26
│           │   ├─ 📂layout
│           │   ├─ 📂menu
│           │   ├─ 📂mipmap-anydpi-v26
│           │   ├─ 📂mipmap-hdpi
│           │   ├─ 📂mipmap-mdpi
│           │   ├─ 📂mipmap-xhdpi
│           │   ├─ 📂mipmap-xxhdpi
│           │   ├─ 📂mipmap-xxxhdpi
│           │   ├─ 📂raw
│           │   ├─ 📂values
│           │   ├─ 📂values-night
│           │   └─ 📂xml
│           └─ 📜AndroidManifest.xml
│       └─ 📂test
├─ 📜build.gradle
├─ 📜build.gradle.kts
├─ 📂gradle
│   ├─ 📜build.gradle
│   ├─ 📜gradle.properties
│   ├─ 📜gradlew
│   ├─ 📜gradlew.bat
│   └─ 📜vsettings.gradle
├─ 📜gradle.properties
├─ 📜gradlew
├─ 📜gradlew.bat
├─ 📜local.properties
└─ 📜settings.gradle

```

### 2️⃣ Spring(Backend)
```
📂devway
├─ 📂.gradle
├─ 📂.idea
├─ 📂build
├─ 📂gradle
├─ 📂src
│  ├─ 📂main
│  │  ├─ 📂java\com\ssafy\devway
│  │  │  ├─ 📂block
│  │  │  ├─ 📂book
│  │  │  ├─ 📂domain
│  │  │  ├─ 📂global
│  │  │  ├─ 📂GPT
│  │  │  ├─ 📂image
│  │  │  ├─ 📂STT
│  │  │  ├─ 📂text
│  │  │  ├─ 📂TTS
│  │  │  ├─ 📂video
│  │  │  └─ 📂weather
│  │  │  └─ 📜DevwayApplication.java
│  │  └─ 📂resources
│  │      └─ 📜application.yml
│  └─ 📂test
├─ 📜.gitignore
├─ 📜build.gradle
├─ 📜docker-compose.yml
├─ 📜Dockerfile
├─ 📜gradlew
├─ 📜gradlew.bat
├─ 📜settings.gradle
└─ 📜Jenkinsfile
└─ 📜README.md

```

<br>

# 💻 역할
|박소현|양성주|김준섭|
|---|---|---|
| **Full stack** | **Full stack** | **Infra** |
| <img src="/uploads/14515b76be2646700c20f3db8d6afd7d/sohyun.png" width="200px" /> | <img src="/uploads/2c37d6d72209561f2b4a9a373705eef8/sungju.jpg" width="200px" /> | <img src="/uploads/48014ee48b321cdec5b6b109857f1f86/junsub.png" width="200px" /> |
| **[BackEnd]** Spring-boot<br/>**[FrontEnd]** Android-native with Java | **[BackEnd]** Spring-boot<br/>**[FrontEnd]** Android-native with Java | Nginx<br/>Docker<br/>Jenkins<br/> |

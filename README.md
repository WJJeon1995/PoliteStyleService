# PoliteStyleService

PoliteStyleService는 Android 접근성 서비스를 활용하여, 사용자가 텍스트를 블록 지정했을 때 "공손하게 / 친근하게 / 비즈니스" 말투로 바꿔주는 기능을 제공하는 앱입니다.

---

## ✨ 주요 기능

- 📌 **텍스트 블록 지정 감지**  
  사용자가 텍스트를 블록 지정하면 자동으로 감지합니다.

- 🪟 **오버레이 버튼 표시**  
  블록 지정 시 "어투 바꾸기" 버튼이 화면에 나타납니다.

- 💬 **말투 스타일 선택**  
  버튼을 누르면 "공손하게 / 친근하게 / 비즈니스" 중 하나를 선택할 수 있습니다.

- 🔁 **말투 변환 및 교체**  
  선택한 스타일로 텍스트를 변환하고 기존 텍스트를 자동으로 대체합니다.

---

## 📱 사용 예시

1. 카카오톡, 메모 앱 등에서 텍스트를 블록 지정합니다.  
2. 화면 우측에 "어투 바꾸기" 버튼이 나타납니다.  
3. 버튼을 누르고 원하는 말투를 선택합니다.  
4. 텍스트가 해당 스타일로 바뀝니다.

---

## 🧩 기술 스택

- Kotlin
- Android Accessibility Service
- WindowManager 오버레이
- GPT API (향후 통합 예정)

---

## 🛠 개발 현황

- [x] 접근성 서비스 설정
- [x] 텍스트 블록 감지
- [x] 오버레이 버튼 UI 구현
- [ ] 말투 변환 기능 연결 (예: GPT API)
- [ ] 설정 화면 (기본 어투 설정 등)

---

## ⚠️ 주의사항

- 본 앱은 Android 접근성 권한을 필요로 합니다.  
- 일부 앱에서는 텍스트 블록 지정 감지가 제한될 수 있습니다.

---

## 📂 프로젝트 구조

```
PoliteStyleService/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── example/
│   │       │           └── politestyleservice/
│   │       │               ├── MainActivity.kt
│   │       │               └── StyleAccessibilityService.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── overlay_buttons.xml
│   │       │   ├── values/
│   │       │   │   ├── strings.xml
│   │       │   │   └── themes.xml
│   │       │   └── xml/
│   │       │       └── accessibility_service_config.xml
│   │       └── AndroidManifest.xml
├── .idea/
│   └── (IDE 설정 파일들)
├── build.gradle
├── proguard-rules.pro
├── settings.gradle
└── README.md
```

## ✅ DevPulse 개발 체크리스트

### 📁 프로젝트 구조

- [x] 개인 GitHub 저장소 생성 (`https://github.com/ran2yo/devpulse`)
- [x] 저장소에 `README.md` 파일 작성
- [ ] `docs/`, `examples/`, `src/main/java`, `src/test/java` 디렉토리 구성

---

### 🧾 README.md 작성 항목

- [x] 프로젝트 개요
- [x] 설치 방법 / 사용 방법
- [x] 기능 리스트
- [x] 데모 이미지(gif) 첨부 (예정)
- [x] 라이선스 명시
- [x] 사용 예제 프로젝트 안내
- [x] CI 설정 안내
- [x] 관련 이슈 링크

---

### ⚙️ 주요 기능 구현

- [x] `DevLog` 기본 구현 (태그 기반 로그 출력)
- [x] ANSI 컬러 + 호출 위치 포함 출력
- [x] `@Profiled` 어노테이션 구현 (Spring AOP)
- [ ] 실행 시간 측정 및 threshold 조건부 출력
- [ ] `spring.profiles.active` 기반 로그 출력 제어
- [ ] 로그 통계 수집 기능 (`LogSummary`)
- [ ] JSON 로그 저장 기능
- [ ] 슬랙 알림 연동 (선택)
- [ ] Spring Boot Starter 버전 (선택)

---

### 🧪 테스트

- [ ] `DevLog` 단위 테스트
- [ ] `@Profiled` 기능 테스트 (AOP 기반)
- [ ] 통계 수집 테스트
- [ ] 로그 포맷 검증 테스트
- [ ] 라인 커버리지 60% 이상

---

### 🧾 예제 프로젝트 추가

- [ ] `examples/basic-log-demo`: DevLog 사용 예제
- [ ] `examples/profiled-demo`: @Profiled 성능 측정 예제

---

### 🚀 퍼블리싱 & 배포

- [ ] Jitpack 퍼블리싱 설정
- [ ] Gradle build script 설정 (`publishing`, `maven`)
- [ ] `v0.1.0` 태깅 후 릴리즈

---

### 🔁 CI/CD 설정

- [ ] GitHub Actions 워크플로우 작성 (`ci.yml`)
- [ ] PR 등록 시 테스트 자동 실행
- [ ] `main` 브랜치 머지 시 릴리즈 트리거

---

### 🗂️ 기타

- [x] 이슈에 저장소 링크 연결
- [ ] `WIP` 상태 언급
- [ ] 리뷰 요청 시 `Needs Review` 코멘트 추가
- [ ] 리뷰 완료 후 `Reviewed` 상태 확인
- [ ] 퍼블리싱 완료 후 `Published` 라벨 확인


src/
└── main/
├── java/
│   └── com/
│       └── library/
│           └── devpulse/
│               ├── DevpulseApplication.java
│               │
│               ├── domain/             ← 🟩 Entity 클래스
│               │   └── User.java
│               │
│               ├── dto/                ← 🟦 요청/응답 DTO
│               │   └── UserDto.java
│               │
│               ├── repository/         ← 🟨 JpaRepository
│               │   └── UserRepository.java
│               │
│               ├── service/            ← 🟧 비즈니스 로직
│               │   └── UserService.java
│               │
│               ├── controller/         ← 🟥 REST API
│               │   └── UserController.java
│               │
│               ├── annotation/         ← @Profiled 어노테이션
│               ├── aspect/             ← AOP 로직
│               └── logging/            ← DevLog 로거 유틸
│
└── resources/
├── application.yml                ← Hibernate 설정 포함
└── schema.sql                     ← (선택) 초기 테이블 생성 SQL

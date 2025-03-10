# Spring 백엔드 트랙 1기 스프린트 미션 제출 리포지토리

| 엔티티 관계                     | 다중성      | 방향성                           | 부모 - 자식 관계                     | 연관관계의 주인      |
|----------------------------|----------|-------------------------------|--------------------------------|---------------|
| users : read_statuses      | 1 : N    | read_statuses -> users 단방향    | 부모 users, 자식 read_statuses     | read_statuses |
| channels : read_statuses   | 1 : N    | read_statuses -> channels 단방향 | 부모 channels, 자식 read_statuses  | read_statuses |
| users : binary_contents    | 1 : 0..1 | users -> binary_contents 단방향  | 부모 binary_contents, 자식 users   | users         |
| users : user_statuses      | 1: 1     | users <-> user_statuses 양방향   | 부모 user_statuses, 자식 users     | user_statuses |
| channels : messages        | 1: N     | messages -> channels 단방향      | 부모 channels, 자식 messages       | messages      |
| users : messages           | 1 : N    | messages -> users 단방향         | 부모 users, 자식 messages          | messages      |
| messages : binary_contents | 1 : N    | messages -> binary_contents   | 부모 binary_contents, 자식 message | messages      |

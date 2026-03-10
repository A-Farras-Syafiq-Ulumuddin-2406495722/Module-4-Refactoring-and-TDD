---
title: Eshop Adv26
emoji: 🌖
colorFrom: purple
colorTo: indigo
sdk: docker
pinned: false
---

# Module 4

## Reflect on TDD FLOW
Dalam flow ini, karena test sudah ditentukan beserta nama untuk method-method yang berhubungan,
rasanya tidak pas karena melihat test yang seharusnya sudah ditentukan tetapi ada error (yang memang bakal di fix)
sehingga error di awal adalah tanda bahwa test bekerja mengevaluasi requirement yang belum terpenuhi.

Dalam Percival (2017) dikatakan kalau test seharusnya di titik beratkan pada "what" daripada "how".
Di module 4 ini sebelum implementasi test-nya harus dilihat dulu requirement-nya.
Jadi ini bagus karena test mendokumentasikan 'apa' yang sistem lakukan ke user dan bukan 'bagaimana' sistem lakukan ke user.

Tapi secara keseluruhan, flow ini cukup efektif karena dengan test yang ditentukan memengaruhi
desain kode yang akan dibuat. Hal ini jadi punya goal-goal kecil yang jelas sehingga pembuatan kode makin lancar.


## F.I.R.S.T
Selama membuat unit test, test dijalankan cepat
dan tidak mengangguw workflow lain. Lalu test dibuat secara terpisah
dan dengan _@BeforeEach_ membuat test-test terisolasi dengan test lain.

Kemudian karena ada banyak test dan ada fase-fase test sehingga
tidak semua unit test langsung dibuat dalam satu tempat sehingga
sering melakukan pengecekan test dan mereka memiliki hasil yang konsisten.

Test yang dibuat terdapat self-validating. Terakhir, ada test untuk Happy dan Unhappy.

Oleh karena itu, saya mengikuti prinsip F.I.R.S.T
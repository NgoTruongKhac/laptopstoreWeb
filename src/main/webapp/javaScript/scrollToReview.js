document.getElementById("scroll-to-review").addEventListener("click", function () {
   const reviewElement = document.getElementById("review");
   const yOffset = -150; // Điều chỉnh khoảng cách so với mép trên (âm để nâng lên).
   const yPosition = reviewElement.getBoundingClientRect().top + window.scrollY + yOffset;

   window.scrollTo({ top: yPosition, behavior: "smooth" });
 });
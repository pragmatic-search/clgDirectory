// Basic JavaScript to handle login functionality and navigation
document.getElementById("login-form").addEventListener("submit", function (e) {
  e.preventDefault(); // Prevent form from submitting the default way

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  const role = document.getElementById("role").value;

  // Basic Validation
  if (username === "" || password === "") {
    alert("Please fill in all fields");
    return;
  }

  // Simulate login and navigation based on role
  if (role === "STUDENT") {
    window.location.href = "student_dashboard.html";
  } else if (role === "FACULTY_MEMBER") {
    window.location.href = "faculty_dashboard.html";
  } else if (role === "ADMINISTRATOR") {
    window.location.href = "admin_dashboard.html";
  } else {
    alert("Invalid role selected!");
  }
});

// Search Functionality for Students
function searchStudents() {
  const searchQuery = document.getElementById("search-bar").value;

  // Simulate search results
  const resultsDiv = document.getElementById("search-results");
  resultsDiv.innerHTML = ""; // Clear previous results

  if (searchQuery) {
    // Mock result data (In actual implementation, you'd query the backend here)
    const mockData = [
      { name: "John Doe", department: "Computer Science", year: "3rd Year" },
      { name: "Jane Smith", department: "Mathematics", year: "2nd Year" },
    ];

    mockData.forEach((student) => {
      const studentDiv = document.createElement("div");
      studentDiv.innerHTML = `<p>Name: ${student.name}, Department: ${student.department}, Year: ${student.year}</p>`;
      resultsDiv.appendChild(studentDiv);
    });
  } else {
    alert("Please enter a search query");
  }
}

// Handle faculty profile update form submission
document
  .getElementById("update-profile-form")
  ?.addEventListener("submit", function (e) {
    e.preventDefault();

    const officeHours = document.getElementById("office-hours").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    // Basic validation
    if (officeHours === "" || email === "" || phone === "") {
      alert("Please fill out all fields");
      return;
    }

    // Simulate saving the updated profile (in reality, you'd send a request to the backend)
    alert("Profile updated successfully!");
  });

// Handle admin add user form submission
document
  .getElementById("add-user-form")
  ?.addEventListener("submit", function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const role = document.getElementById("role").value;

    if (name === "" || email === "") {
      alert("Please fill in all fields");
      return;
    }

    // Simulate adding the user (you'd send a request to the backend here)
    alert(`New user ${name} (${role}) added successfully!`);
  });

import cv2
import dlib

# Load the pre-trained face detection model
detector = dlib.get_frontal_face_detector()

# Load the pre-trained face recognition model
predictor = dlib.shape_predictor('shape_predictor_68_face_landmarks.dat')
face_recognizer = dlib.face_recognition_model_v1('dlib_face_recognition_resnet_model_v1.dat')

# Load the reference image and encode the face
reference_image = cv2.imread('reference.jpg')
reference_gray = cv2.cvtColor(reference_image, cv2.COLOR_BGR2GRAY)
reference_faces = detector(reference_gray)

if len(reference_faces) == 1:
    reference_landmarks = predictor(reference_gray, reference_faces[0])
    reference_face_encoding = face_recognizer.compute_face_descriptor(reference_image, reference_landmarks)

# Load the test image and recognize faces
test_image = cv2.imread('test.jpg')
test_gray = cv2.cvtColor(test_image, cv2.COLOR_BGR2GRAY)
test_faces = detector(test_gray)

for face in test_faces:
    landmarks = predictor(test_gray, face)
    face_encoding = face_recognizer.compute_face_descriptor(test_image, landmarks)

    # Compare the face encoding with the reference face encoding
    distance = dlib.distance(reference_face_encoding, face_encoding)

    if distance < 0.6:
        # Detected face matches the reference face
        cv2.rectangle(test_image, (face.left(), face.top()), (face.right(), face.bottom()), (0, 255, 0), 2)
        cv2.putText(test_image, 'Match', (face.left(), face.top() - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.9, (0, 255, 0), 2)
    else:
        # Detected face does not match the reference face
        cv2.rectangle(test_image, (face.left(), face.top()), (face.right(), face.bottom()), (0, 0, 255), 2)
        cv2.putText(test_image, 'No match', (face.left(), face.top() - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.9, (0, 0, 255), 2)

# Display the result
cv2.imshow('Face Recognition', test_image)
cv2.waitKey(0)
cv2.destroyAllWindows()

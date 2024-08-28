import os
import shutil

def reconstruct_structure_and_rename_files(original_src_dir, annotated_src_dir, output_dir):
    # Walk through the original source directory
    for root, dirs, files in os.walk(original_src_dir):
        # Calculate the relative path to reconstruct in the output directory
        rel_path = os.path.relpath(root, original_src_dir)
        new_root = os.path.join(output_dir, rel_path)

        # Create the new directory structure in the output directory
        if not os.path.exists(new_root):
            os.makedirs(new_root)

        for file in files:
            if file.endswith('.java'):
                original_java_file = os.path.join(root, file)
                annotated_file_pattern = file.replace('.java', '-org.checkerframework.checker.nullness.NullnessChecker.ajava')
                
                # Check for the NullnessChecker.ajava file in the corresponding directory in the annotated src
                possible_annotated_dir = os.path.join(annotated_src_dir, rel_path)
                annotated_java_file = os.path.join(possible_annotated_dir, annotated_file_pattern)

                # If the NullnessChecker.ajava file exists, use it; otherwise, use the original .java file
                if os.path.exists(annotated_java_file):
                    target_file = os.path.join(new_root, file)
                    shutil.copyfile(annotated_java_file, target_file)
                else:
                    target_file = os.path.join(new_root, file)
                    shutil.copyfile(original_java_file, target_file)

# Define paths
original_src_dir = 'src'
annotated_src_dir = 'wpi-out'
output_dir = 'wpi-out-java'

# Run the function
reconstruct_structure_and_rename_files(original_src_dir, annotated_src_dir, output_dir)

